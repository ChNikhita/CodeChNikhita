
#################################################################################################

import json,os,sys
from pprint import pprint
import pip
import subprocess

with open('Dependencies.json') as f:
    data = json.load(f)
python_obj=(data["Dependencies"])

## Creates a file "Packages&Versions which consist of packages that to be download "

f=open("Packages&Versions.txt","w+")
for element in python_obj:
	f.write(element+"=="+python_obj[element])
	f.write("\n")
f.close()
with open("Packages&Versions.txt") as fp:  
   line = fp.readlines()
   i=line
   # print (i)
success=[]
failure=[]
Packages_count=len(i)
print (Packages_count)
cmd="python -m pip install "
for n in i:
	# print n
	return_value = os.system(cmd+n)
	# return_value = subprocess.call(cmd+n, shell=True)
	if(return_value==0):
		print "Successfully Installed  "+n
		success.append(n)
	else:
		print "####### failed to install #########  "+n
		failure.append(n)
