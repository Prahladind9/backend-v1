EC2 - Elastic Compute Cloud
AMI - Amazon Machine Image
AZ  - Availability Zone
VPC - Virtual Private Cloud
ASG - Auto Scaling Groups

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
      Customized AMI
         Hardening an Image - Customize EC2 images to your corporate security standards

      AMIs are stored in Amazon S3 (region specific)

      EC2 Security - Key Pairs
         1) EC2 uses public key cryptography for protecting login credentials
         2) Key pair - public and private key
               public key is stored in EC2 instance
               private key is stored by customer

         To connect via SSH - private key       
         1) check permission "chmod 400 ec2-default.pem"
         2) if permission is 0777 > we get warning saying
            "Permissions 0777 for 'ec2-default.pem' are too open"
         3) for windows, in addition to private key, you need admin password
         4) Security Group should allow inbound SSH or RDP access (usually timeout error)
               Port 22   - Linux EC2 instance (SSH)
               Port 3389 - RDP (Remote Desktop - Windows)

         5) We connect to instance using its 
            Public DNS: ec2-**-**-**-**.compute.amazonaws.com

      Important ECS Scenarios
         1) To save billing from Elastic Blob Store - Volume > Terminate the instance
            as user will be charged for volume, eventhough the instance is stopped

         2) You want to identify all instances belonging to a project,
            to an environment to to a specific billing type?
            Add Tags. Project - A. Enviroment - Dev
         3) You want to change instance type? (Volume increase) 
            Stop the instance
            Use "Change Instance Type" to change and restart
         4) You dont want an EC2 instance to be automatically terminated
            Turn on Termination Protection
            *Remember EC2 Termination Protection is not effective for terminations from
               a) Auto Scaling Groups (ASG)
               b) Spot Instances
               c) OS Shutdown ie., SSH login and command shutdown
         5) You want to update the EC2 instance to a new AMI updated with latest patches
            Relaunch a new instance with an update AMI

         6) Create EC2 instances based on on-premise Virtual Machine (VM) images
            Use VM Import/Export. You are responsible for licenses.
         7) Change Security Group on an EC2 instance
            Assign at launch or runtime. Security Group changes are immediately effective      
         8) You get a timeout while accessing an EC2 instance
            Check your Security Group configuration
         9) You are installing a lot of software, using user data, slowing down instance launch.
            How to make it faster?
            Create an Custom AMI from the EC2 instance and use it for launching new instances

         10) Ive stopped my EC2 insatnce. Will I be billed for it?
             ZERO charge for a stopped instance (If you have storage attahced, you have to pay for storage)

      VPC - Virtual Private Cloud > Subnet > availability regions

(2) Billing   
   Stop services or any resource which isnt accessed, check weekly and add alerts
   SNS - Simple Notification Service
   Create Alarm using CloudWatch or AWS Budgets

(3) Load Balancing
   Elastic Load Balancer
   1) Distribute traffic across EC2 instances in one or more Availability Zones in a single region
   2) Managed Service - AWS ensures that it is highly available
   3) Auto scales to handle huge loads
   4) Health checks - route traffic to healthy instances
   
   HTTP vs HTTPS vs TCP vs TLS vs UDP vs IP
      1) Application Layer: Make REST API calls and Send Emails
         HTTP : Hypertext Transfer Protocol: Stateless Request Response Cycle
         HTTPS: Secure HTTP 
         SMTP : Email Transfer Protocol
         FTP  : File Transfers
      
      2) Transport Layer: Are the bits and bytes transferred properly?
         TCP: Transmission Control: Reliability > Performance
         TLS: Transport Layer Security: Secure TCP
         UDP: User Datagram Protocol: Performance > Reliability

      3) Network Layer : Transfers bits and bytes
         IP: Internet Protocol, Unreliable 
         

      a) Each layer makes use of the layers beneath it
      b) Most applications typically communicate at application layer
      c) However applications needing high performance directly commincate at transport layer
         Gaming applications and live video streaming use UDP (sacrifice reliability for performance)

   3 types of Elastic Load Balancers
      1) Classic Load Balancer (Layer 4 and Layer 7)
         Old generation supporting layer 4 (TCP/TLS) and layer 7 (HTTP/HTTPS) protocols
         Not Recommended by AWS

      2) Application Load Balancer (Layer 7)
         New generation supporting HTTP/HTTPS and advanced routing approaches
      3) Network Load Balancer (Layer 4)
         New generation supporing TCP/TLS and UDP
         Very hight performance usecases
      4) Gateway Load Balancer
         IP 

      Listeners
      1) Each Load Balancer has one or more listeners listening for connection requests from the client
      2) Each listener has: a protocol, a port, a set of rules to route requests to targets         
      3) Can have Multiple Listeners listening for a different protocol or port
      
      Target Groups (Attributes)
      1) Deregistration Delay (0 to 3600 sec) Connection Draining
      2) Slow start duration
      3) Load balancing algorithm: Round robing or Least outstanding requests
      4) Stickiness - sends all requests of one user to one instance > via cokkie

      Microservices architectures - Multiple Target Groups
         1) By configiruing Rules for multiple listener we can identify which request
            should be sent to which target group
         2) Rules are executed in the order they are configured   
         
         Listener Rules - Possibilites, based on
         1) path          : micro/a to targetGroupA and micro/b to targetGroupB
         2) host          : a.micro to targetGroupA and b.micro to targetGroupB
         3) HTTP headers  : Authorization header and methods (POST, GET, etc) 
         4) Query Strings : example(/micro?taget=a)
         5) IP Address    : all requests from a range of IP address to targetGroupA

         Architecture Summary
         1) Highly decouple architecture
         2) Load balancer can have multiple listeners (protocol + port combinations)
         3) Each listener can have multiple rules each routing to a target group based on request content

      Auto Scaling Componenets   
      1) Launch Configuration/Template
         > EC2 instance size and AMI
      2) Auto Scaling Group
         > Reference to Launch Configuration/Template
         > Min, max and desired size of ASG
         > EC2 health checks by default. Optionally enable ELB health checks.
         > Auto Scaling Policies (CPU usage based scaling)


      Auto Scaling Groups (ASG)
         Target Groups are configured with a static set of instances.
         How do you scale out and scale in automatically?
         > Confgure a Auto Scaling Group
            1) Maintain configured number of instances (using periodic health checks)
            2) Auto scale to adjust to load (scale-in and scale-out based on auto scaling policies)
         > ASG can launch On-Demand Instances, Spot Instances, or both
            1) Best Practice: USe Launch Template
         > An ELB can distribute load to active instances, as ASG expands and contracts based on the load.
      UseCases
         1) Maintain current instance levels at all times
         2) Scale Manually
         3) Scale based on a schedule
         4) Scale based on demand (Dynamic)
            > Target tracking scaling (CPU based)
            > Simple Scaling
            > Step Scaling   

      Network Load Balancer
         1) Functions at the Transport Layer - Layer 4 (Protocols TCP, TLS and UDP)
         2) For hught performance use cases (millions of request per second)
         3) Can be assigned a Static IP/Elastic IP
         4) Can load balance between
            > EC2 instances
            > Containerized applications (Amazon ECS)
            > Web applications (using IP addresses)

      Designing Solutions with EC2 and ELB for AWS Architects             




