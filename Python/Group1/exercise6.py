triNumber = int(input("Please, enter the number of triangular numbers you want to produce:"))
for n in range (1,triNumber+1):
    amount = (n*(n + 1))//2
    print (amount, end=' ')
    
