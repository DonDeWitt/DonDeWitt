#This program allows the user to explore the results of Bing Map's API Auto-suggest featyre
#By Donald DeWitt
import requests, json, mysql.connector


API_KEY = "CONFIDENTIAL"
print("You can use this tool to search Bing Maps API's autosuggest feature by specifying a country and a keyword")

#Get user input
country = input("Enter 2 character country code, ex. US: ").upper()
keyword = input("Enter keyword for search, ex. 'hiking': ")

#format query string for API
url = "http://dev.virtualearth.net/REST/v1/Autosuggest?query=" + keyword + "&includeEntityTypes=Place&maxResults=10&countryFilter=" + country + "&key=" + API_KEY

#Queries API and converts it from JSON object to dictionary object
apiData = json.loads(requests.get(url).text)
resources = apiData["resourceSets"][0]["resources"][0]["value"]

print("Here is what Bing Maps Autosuggest API could come up with:\n\n")
print(json.dumps(resources, indent=4))

#The following code, which is commented out as it is not needed for this implementation (and will throw an exception if mySQL is not configured to these exact specifications,
#is for sending the retrieved data to a locally hosted mySQL server.
'''
db = mysql.connector.connect(
    host="localhost",
    user="don",
    passwd="CONFIDENTIAL",
    database="sys"
    )

mycursor = db.cursor()
mycursor.execute("USE SYS;")

for i in resources:
    locationtype = i["__type"]
    state = i["address"]["adminDistrict"]
    name = i["name"]
    dataSet = "'" + name + "', '" + state + "', '" + locationtype + "'"
    print(dataSet)
    mycursor.execute("INSERT INTO sys.places(name, state, locationtype) VALUES (" + dataSet + ");")

db.commit()
mycursor.close()
db.close()
'''


