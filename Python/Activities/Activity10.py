num_tuple = (10, 25, 333, 56, 87)
print("Given list is ", num_tuple)

print("Elements that are divisible by 5:")
for num in num_tuple:
    if (num % 5 == 0):
        print(num)