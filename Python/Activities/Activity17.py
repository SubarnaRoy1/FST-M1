import pandas

data = {
    "Usernames": ["admin", "Subarna", "Sneha"],
    "Passwords": ["password", "Roy12", "Dey3"]
}

dataframe = pandas.DataFrame(data)
print(dataframe)

dataframe.to_csv("sample.csv", index=False)