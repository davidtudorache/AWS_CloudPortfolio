# AWS_CloudPortfolio
I was tasked with the deployment of a simple java web application to the cloud. I selected the Amazon Web Service (AWS) cloud service provider and subsequently setup and configure a virtual machine instance that was able to host a java web application. I also installed and configured a MySQL database server locally on the same virtual machine hosting the web app (i.e. localhost), as the web application also utilised a MySQL database. Finally, I developed and deployed a cloud function on AWS Lambda.

To run the AWS lambda function it first must be imported into eclipse (instructions below):
Open the import wizard -> File > Import... > Existing Projects into Workspace
Select the archive file (path you have downloaded zip file in)
Run > Run As > Run the project as a Maven Project (If this doesn't work go into the run configuration and select maven build from there)
