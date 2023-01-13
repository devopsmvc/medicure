terraform {
  required_providers {
    aws = {
      source = "hashicorp/aws"
      version = "4.50.0"
    }
  }
}

provider "aws" {
  region = "ap-south-1"
  
}

resource "aws_vpc" "terraform_vpc" {
  cidr_block = "10.0.0.0/16"
  instance_tenancy = "default"

  tags = {
    Name = "terraform_vpc"
    Location = "Bangalore"
  }
}

resource "aws_internet_gateway" "igw" {
  vpc_id = aws_vpc.terraform_vpc.id

  tags = {
    "Name" = "terraform"
  }
}

resource "aws_route_table" "public" {
  vpc_id = aws_vpc.terraform_vpc.id

  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.igw.id
  }

  tags = {
    "Name" = "Public route table - terraform"
  }
}

resource "aws_subnet" "public" {
  vpc_id     = aws_vpc.terraform_vpc.id
  cidr_block = "10.0.1.0/24"
  map_public_ip_on_launch = true

  tags = {
    "Name" = "Public-Subnet"
  } 

  /* route_table_id = aws_route_table.terraform.id */
}

resource "aws_security_group" "terraform" {
  name   = "terraform"
  vpc_id = aws_vpc.terraform_vpc.id

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 443
    to_port     = 443
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_network_interface" "terraform" {
  subnet_id = aws_subnet.public.id
  security_groups = [aws_security_group.terraform.id]

  tags = {
    "Name" = "terraform"
  }
}

/* resource "aws_eip" "eip_nat" {
  vpc      = true

  tags = {
    "Name" = "EIP1"
  }
  
}

resource "aws_eip_association" "eip_assoc" {
    allocation_id = aws_eip.eip_nat.id
    network_interface_id = aws_network_interface.terraform.id
  
} */

resource "aws_instance" "terraform" {
  ami           = "ami-07ffb2f4d65357b42"
  instance_type = "t2.micro"
  availability_zone = "ap-south-1b"
  key_name = "devops"


  tags = {
    "Name" = "Terrform"
  }
  network_interface {
    device_index = 0
    network_interface_id = aws_network_interface.terraform.id
  }

  /* connection {
    type        = "ssh"
    user        = "ubuntu"
    private_key = file("~/.ssh/id_rsa")
  } */

  /* provisioner "remote-exec" {
    inline = [
      "sudo apt-get update",
      "sudo apt-get install -y apache2"
    ]
  } */
}

