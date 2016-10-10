proNumber = int(input("Please, enter the number of pronic numbers you want to produce:"))
for n in range (1,proNumber+1):
    amount = (n*(n + 1))
    print (amount, end=' ')
    
