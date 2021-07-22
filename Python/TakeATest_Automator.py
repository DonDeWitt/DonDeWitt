#Take-A-Test URL formatter and shortenner
#By Donald DeWitt
'''
This tool is for quickly creating links to Take-A-Test
to esnure academic integrity of online quizzes.
Created by Donald DeWitt, June 1st, 2021
This code does not work as intended due to the TinyURL API
not handling URL shortening in the same way as their web interface.
Although the returned URL will open in Take-A-Test, the test does not open
in lockdown mode (the end tag /#enforcelockdown is ignored by the API
'''
import requests

token = "4387c4be307fdc73dc2861d433ceb5f65037d832"
print('''This tool is for automating link creation for Take-A-Test \n
      to esnure academic integrity of online quizzes. \n
      Created by Donald DeWitt, June 1st, 2021 \n''')
#Get URL from user
fullQuizLink = input('Enter the URL: ')

#Format URL as a "Take-A-Test" link
fullQuizLink = 'ms-edu-secureassessment:' + fullQuizLink
if(fullQuizLink[-1] != '/'):
    fullQuizLink = fullQuizLink + '/\x23enforcelockdown'
else:
    fullQuizLink = fullQuizLink + '\x23enforcelockdown'
#TinyURL API connector
api = 'http://tinyurl.com/api-create.php?url='

#Query and store API response
response = requests.get(api + fullQuizLink)
#print(fullQuizLink)
#print the API response for the user
print("Share the following Take-a-Test link with your students:")
print(response.text)

