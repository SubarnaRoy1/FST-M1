import pandas
from pandas import ExcelWriter

data = {
    'FirstName':["Subarna", "Sneha", "Nilay"],
    'LastName':["Roy", "Basu", "Sen"],
    'Email':["sroy1@example.com", "snehabasu@example.com", "nilay.sen@example.com"],
    'PhoneNumber':["8767667788", "4545343322", "8976567867"]
}

dataframe = pandas.DataFrame(data)

print(dataframe)
writer = ExcelWriter('sample.xlsx')
dataframe.to_excel(writer, 'Sheet1', index = False)

writer.save()