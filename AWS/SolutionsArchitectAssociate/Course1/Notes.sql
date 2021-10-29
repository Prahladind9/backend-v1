EC2 - Elastic Compute Cloud
AMI - Amazon Machine Image
AZ  - Availability Zone
VPC - Virtual Private Cloud
ASG - Auto Scaling Groups

"A Purpose & commitment to learn the technology"

01 Introduction - AWS Certified Solutions Architect Associate
02 Getting Started - AWS Certified Solutions Architect Associate
03 Understanding Regions and Availability Zones

(4) Getting started with AWS Virtual Servers - EC2 Service and EC2 Instances
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
      1) Virtual firewall to control incoming and outgoing traffic to/from
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
             ZERO charge for a stopped instance (If you have storage attached, you have to pay for storage)

      VPC - Virtual Private Cloud > Subnet > availability regions

(5) Take care of Billing in the Cloud
      Stop services or any resource which isnt accessed, check weekly and add alerts
      SNS - Simple Notification Service
      Create Alarm using CloudWatch or AWS Budgets

(6) Load Balancing Solutions in AWS - Elastic Load Balancing
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
         2) For high performance use cases (millions of request per second)
         3) Can be assigned a Static IP/Elastic IP
         4) Can load balance between
            > EC2 instances
            > Containerized applications (Amazon ECS)
            > Web applications (using IP addresses)

                
(7) Designing Solutions with EC2 and ELB for AWS Architects
   1) Availability
         1) Are the applications available when the users need them?
         2) % if time an application provides the operations expected of it.
         3) Example 
            1) 99.999 > five 9s > 26 seconds > per month downtime > achieving this is tough
            2) 99.99% > four 9s > 4 and half minutes  > per month > most online apps aim this
         4) Basics
            1) Deploy to multiple AZs
            2) Use Cross Zone Load Balancing   
            3) Deploy to multiple regions
            4) Configure proper EC2 and ELB health checks

   2) Scalability
         A system is handling 1000 transactions per second.
         Load is expected to increase 10 times in the next month
         1) Can we handle a growth in users, traffic, or data size without any drop in performance?
         2) Does ability to serve more growth increase proportionally with resource?

      1) Vertical Scaling
         1) Deploying application/database to bigger instance (small to Xlarge)
            > A larger hard drive
            > A faster CPU
            > More RAM, CPU, I/O, or networking capabilities
         2) There are limits to vertical scaling
            > for example no of CPUs for the given instance
            > can be expesive
         3) Increasing EC2 instance size   
            > t2.micro to t2.small or
            > t2.small to t2.2xlarge ...

      2) Horizontal Scaling
         1) Deploying multiple instances of application/database
         2) increases availability
         3) Distribute EC2 instances
            > in a single AZ
            > in multiple AZs in single region
            > in multiple AZs in multiple regions
         4) Auto scale: Auto Scaling Group
         5) Distribute Load: Elastic Load Balancer, Route53 (for AZs in multiple regions)

      3) EC2 Instance Families
         1) m(m4, m5, m6): General Purpose
            > Balance of compute, memory and networking
            > UseCase: Web servers and code repositories
         2) t(t2, t3, t3a): Burstable performance instances
            > accumulate CPU credits when inactive
            > Unlimited burstable mode at additional cost (new feature)
              * t2, Unlimited Mode is disabled by default
              * t3, Unlimited Mode is enabled by default 
            > UseCase: Workloads with spikes
              Test environmentsWeb servers, developer environments and small dbs

         3) c(c4, c5, c5n): Compute optimized
            > High performance processors
            > UseCase: Batch processing, 
              high performance http servers, high performance computing (HPC)

         4) r(r4, r5, r5a, r5n): Memory (RAM) optimized
            > Memory caches, in-memory databases and real time big data analytics  

         5) i(i3, d2): Storage (I/O) optimized
            > NoSQL databases and data warehousing

         6) g(g3, g4): GPU optimized
            > Floating point number calculations, graphics processing, or video compression      
         
         7) f(f1): FPGA instances - customizable field programmable gate arrays
            > Applications needing massively parallel processing power,
              such as genomics, data analytics, video processing and financial computing

         8) inf(inf1): Machine learning ASIC instance
            > Machine learning applications such as image recongnition, speech recognition,
              natural language processing and personalization     

      4) EC2 Tenancy - Shared or Dedicated
         1) Shared Tenancy (Default)
            > Single host machine can have instances from multiple customers

         2) EC2 Dedicated Instances
            > in case of country-region based regulatory norms
            > Virtualized instances on hardware dedicated to one customer
            > You do NOT have visibility into the hardware of underlying host

         3) EC2 Dedicated Hosts
            > Physical servers dedicated to one customer
            > You have visibility into the hardware of underlying host (sockets and physical cores)
            > UseCase: Regulatory needs or server-bound software licenses like Windows Server, SQL Server

      5) EC2 Placement Groups
            1) Certain usecases need control over placement of a group of EC2 instances
               > Low latency network connection
               > High availability
                  
            2) You do not want EC2 to decide that for you!
            3) Go for EC2 placement groups!
               1) Cluster (low network latency) - 10Gbps or 25Gbps
                     > Big Data or High Performance Computing needing extreme low latency 
               2) Spread (avoid simultaneous failures)
                     > Each rack has its own network and power source
                     > Avoid simultaneous failures of EC2 instances
                     
               3) Partition (multiple paritions with low network latency)
                     > In large distributed and replicate workloads (HDFS, HBase, and Casssandra)
                     > Maximum of 7 running instances per AZ in a spread placement group 

            4) Insufficient capacity error

      6) Elastic Network Interface (ENI)
            1) Logical networking component that represents a virtual network card.
            2) Support IPv4 (110.120.120.145) and IPv6 (2001:odb8:85a3:0000:0000:8a2e:0370:7334)
            3) Each ENI can provide:
               a) One primary and multiple secondary private IP address
               b) One public address
               c) One Elastic IP address per private IPv4 address
               d) One or more security groups

         Two Types: Primary and Secondary 
            1) Each EC2 instance is connected to primary network interface (eth0)
            2) You can create and attach a secondary network interface - eth1
            3) Allows an instance to be dual homed - present in 2 subnets in a VPC
            4) Used to create a management network or a low budget high availability solution
         
         Terminology:
            1) Hot attach: Attaching ENI when EC2 instance is running
            2) Warm attach: Attaching ENI when EC2 instance is stoped
            3) Cold attach: Attaching ENI at launch time of EC2 instance

      6) Cloud Watch
         1) Amazon CloudWatch used to monitor EC2 instances
         2) (Free) Basic Monitoring (every 5 mins)
         3) ($$$$) EC2 Detailed Monitoring, can be enabled for detailed metrics every 1 min 
         4) EC2 System Level metrics (CPI, Disk, Network) are tracked
      
      7) EC2 Pricing Models Overview
         1) EC2 on-Demand (Spiky workloads)
         2) EC2 Spot Instances (Cost sensitive, Fault tolerant, Non immediate workloads)
            a) Spot Block (specific duration 1 or 2 or 6 .. hrs)
            b) Spot Fleet (range of instance types)
         3) EC2 Reserved Instances (Constant workloads that run all the time)
            a) Reserve EC2 instance ahead of time!
            b) three types > standard, convertible, scheduled
            c) payment methods 
               1) No Upfront: $0 upfornt. Pay monthly installement
               2) Partial Upfront: $XYZ upfornt. Pay monthly installement
               3) All Upfront: Full amount upfornt. $0 monthly installement
               4) Cost wise: Earlier you pay, more the discount.
                  All Upfront < Partial Upfront < No Upfront (5% diff)
             Summary
               1) Standard: Commit for a EC2 platform and instance family
                            for 1 year or 3 year (upto 75% off)
               2) Convertible: Standard + flexibility to change EC2 & instance (54% off)
               3) Scheduled: Reserve for specific time period in a day (5-10% off)
               4) You can sell reserved instances on the 
                  AWS Reserved instancce marketplace if you do not want to use your reservation

         4) Savings Plans 
            Constant workloads that run all the time and you want more flexibility         
        
         https://instances.vantage.sh/


** AWS Managed Service Offerings
   1) Elastic Load Balancing - Distribute incoming traffic across multiple targets
   2) AWS Elastic Beanstalk - Run and Manage Web applications
   3) AWS Elastic Container Service (ECS) - Container orchestration on AWS
   4) AWS Fargate - Serverless compute for containers  
   5) Amazon Elastic Kubernetes Service (EKS) - Run Kubernetes on AWS
   6) Amazon RDS - Relational Databases - MySQL, Oracle, SQL Server etc

(8) Getting started with AWS Elastic Beanstalk
      1) Simplest way to deploy and scale your web application in AWS
         Provies end-to-end web application management
      2) No usage charges - Pay only for AWS resources you provision
      3) Features:
         Automatic load balancing
         Auto Scaling
         Managed platform updates
         Application health monitoring


(9) Container Solutions in AWS - ECS Fargate and EKS
      1) Microservices architectures - build small focused microservices
      2) Flexibility to innovate & build applications in different programming languages
         but deployments become complex

(10) Architect Serverless Solutions with AWS Lambdas and API Gateway
      1) Serverless and Lambdas
      2) API Gateway
         1) API Lifecycle Management for RESTful APIs and WebSocket APIs
         2) Run multiple versions of the same API
         3) Rate Limits, throttling and fine-grained access permissions 
            using API Keys for Thrid-Party Developers
         4) Authorization Integration 
            AWS IAM, Cognito, Lambda authorizer

(11) Architect Your Private Networking Solutions in AWS with VPC and Subnet
      1) CIDR (Classless Inter-Domain Routing) Blocks
         1) range if addresses that resources in  a network can have
         2) www.cidr.xyz
         3) How many addresses does 69.208.0.0/26 represent?
            2 to the power ((32-26)=6) => 64 addresses from 69.208.0.0 to 69.208.0.63
      2) Run APIs via Crontab and trace using X-Ray
      3) An Internet Gateway enables internet communication for subnets
      4) Any subnet which has a route to an internet gateway is called a public subnet
      5) Any subnet which doesn not have route to an internet gateway is called a private subnet      
      6) Network Address Translation (NAT) Instance and Gateway
         1) Prefer NAT Gateway over NAT Instance
         2) NAT Gateway supports IPv4 Only
         3) Use Egress-Only Internet Gateway for IPv6
      7) NACL - Network Access Control List

(12) Getting Started with Amazon S3 - Object Storage in AWS
      1) S3 is global service, buckets are created in specific AWS region
      2) Objects are stored in buckets, whose names are globally unique & 5TB max object size 
      3) key value pair
      4) Versionsing - protects against accidental deletion, 
         is optional, once enabled can only be suspended - the versions objects cannot be deleted
      5) Resource-based policies - Bucket Policies
         can grant cross-account and global access
      6) Object Lock > write-once-read-many > can only be enabled during object creation     
      7) Tags > key-value pairs
      8) Lifecycle policies
      9) Transfer acceleration
     10) Requester pays
     11) Event Notifications
     12) Lifecycle Rules
     13) Storage Class
     14) Encryption 
     15) Object Access Control List (ACL) 
     16) Replication (Versionsing should be enabled on both source & destination - in same or different regions)
     17) S3 Eventual Consistency
     18) Presigned URL
     19) Access Points
     20) Security 
     21) Cost
         1) Cost of Storage per GB
         2) Retrieval Charge per GB
         3) Monlthly tiering fee (only for Intelligent Tiering) 
         4) Data transfer fee
         5) Free of cost
            a) into s3
            b) from s3 to Amazon CloudFront 
            c) from s3 to services in same region
     22) Performance (Multipart Upload API (file size > 100MB, for > 4GB mandatory)
     23) Features
     24) S3 Glacier

(13) Getting Started with IAM - Identity and Access Management in AWS
      1) Authentication (is it the right user?)
      2) Authorization (do they have the right access?)
      3) Identities can be 
         a) AWS users or 
         b) Federated users (externally authenticated users)
      4) AccessKey - instance connect via command line - aws configure (not recommended)
      5) permission via role
      6) IAM Cross Account Access using Roles (Policy: SecureTokenService (STS) & switch role)
      7) Federation with IAM role (Corporate Directory: SAML 2.0)
      8) Web Identity Federation (OpenID: facebook, google ...) Amazon Cognito
      9) Identity-based and Resource-based policies
     10) Password Policy, 2 Access Keys
         IAM roles is NOT associated with long-term credentials or IAM User
         Enable MultiFactorAuthentication (MFA) - Hardware or virtual device

(14) Data Encryption Solutions in AWS - KMS and Cloud HSM
      1) Data States: Data at rest, in motion, in use
      2) Encryption
         1) First law of security: Defense in Depth   
         2) Symmetric Key Encryption
         3) Asymmetric Key Encryption (Public & Private Key also called Public Key Cryptography)
      3) Key Management Service (KMS), Envelop Encryption, shared
      4) Clould Hardware Security Module (HSM), dedicated single-tenant 

(15) Block Storage Solutions in AWS - Elastic Block Storage EBS and Instance Store
      1) Block Storage (Amazon EBS)
         a) Direct-attached storage - Similar to a hard disk
         b) Storage Area Network (SAN) - High speed network
         c) One virtual server at a time
      2) File Storage (Amazon EFS, FSx) - multiple virtual servers at a time
      3) RAID - 0, 1

(16) File Storage Solutions in AWS - EFS and FSx
(17) Getting Started with AWS Storage Gateway 
     Hybrid Storage File, Tape and Volume - Cached & Stored










