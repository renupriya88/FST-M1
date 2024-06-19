import pandas as pd
from pandas import ExcelFile
from pandas import ExcelWriter

#Create a dictionary
dic = {
    "FirstName" : ["Satvik", "Avinash", "Lahri"],
    "LastName" : ["Shah", "Kati", "Rath"],
    "Email" : ["satshah@example.com", "avinashk@example.com", "lahri.rath@example.com"],
    "PhoneNumber" : ["4537829158", "5892184058", "4528727830"]
}

# Create a new DataFrame using the data
dataframe = pd.DataFrame(dic)
	
# Print the DataFrame
print(dataframe)

writer = ExcelWriter("activity19.xlsx")

#write to excel
dataframe.to_excel(writer,"Sheet1")

#close excel
writer.close()