(1) Getting started with AWS Virtual Servers - EC2 Service and EC2 Instances
General Commands
        yum means (yellow updater)
        yum update -y
    a)  whoami
    b)  python --version
    c)  ls
    d)  pwd
    e)  sudo su
    f)  yum install httpd -y
    g)  systemctl start httpd
    h)  systemctl enable httpd 
    i)  service httpd status
    j)  history

   Instance Metadata Service
   curl http://169.254.169.254/latest/meta-data

   ami-id
   ami-launch-index
   ami-manifest-path
   block-device-mapping/
   events/
   hibernation/
   hostname
   identity-credentials/
   instance-action
   instance-id
   instance-life-cycle
   instance-type
   local-hostname
   local-ipv4
   mac
   managed-ssh-keys/
   metrics/
   network/
   placement/
   profile
   public-hostname
   public-ipv4
   public-keys/
   reservation-id
   security-groups

   ex: curl http://169.254.169.254/latest/meta-data/ami-id

   Dynamic Data Service
   curl http://169.254.169.254/latest/dynamic

   instance-identity/
      rsa2048
      document
      signature
      pkcs7

   ex: http://169.254.169.254/latest/dynamic/instance-identity/document

   Setting up a HTTP Server
   echo "Getting started with AWS" > /var/www/html/index.html
   echo "Welcome to in28minutes $(whoami)" > /var/www/html/index.html
   echo "Welcome to in28minutes $(hostname)" > /var/www/html/index.html
   echo "Welcome to in28minutes $(hostname -i)" /var/www/html/index.html
   curl http://169.254.169.254/latest/dynamic/instance-identity/document > /var/www/html/index.html

   -s means silent mode
   curl -s http://169.254.169.254/latest/dynamic/instance-identity/document > /var/www/html/index.html

   Security Groups
      1) Virual firewall to control incoming and outgoing traffic to/from
         AWS resources (EC2 instances, databases etc)
      2) Provides additional layers of security - Defense in Depth

      Q) What if there are no security group rules configured for inbound and outbound?
      a) Default DENY. No traffic is allowed in and out of EC2 instance.

      Q) Can I change security groups at runtime?
      a) Yes, changes are immediately effective

   EC2 IP Addresses
      1) Public IP addresses are internet addressable
      2) Private IP addresses are internal to a corporate network
      3) You CANNOT have two resources with same public IP address.
      4) HOWEVER, two different corporate networks CAN have resources
         with same private IP address

   Elastic IP Addresses
      Q) How do you get a constant public IP address for a EC2 instance? (assume only single instance)
      a) Quick and dirty way is to use an Elastic IP!
      
      You'll be charged for Elastic IP > even when u don't use it

   Simplify EC2 HTTP server setup

      Bootstrapping: Install OS patches or software when an EC2 instance is launched
      Lookup user data > curl http://169.254.169.254/latest/user-data/
   
      Create New Instance and configure user data as below
         #!/bin/bash
         yum update -y
         yum install httpd
         systemctl start httpd
         systemctl enable httpd
         curl -s http://169.254.169.254/latest/dynamic/instance-identity/document > /var/www/html/index.html

      Launch Templates   








