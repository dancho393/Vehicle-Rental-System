My solution has 3 packages config,model and cli:
model contrains all the classes like(invoice,vehicle and similar)
config contains the start up data 
cli contrains all calculations and methods for creating classes

--base package contrains interfaces and abstract classes
-- I have Command interface and CommandRequest(what method gets as an input),CommandReposne(what method return)
--Every Command has an separate interface,request,reposne which extend the basic ones
--command package in cli is for the request,response,command class and interfaces and the impl package is for their implementation
