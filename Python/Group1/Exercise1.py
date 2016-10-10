n=8
k=1
for i in range (1,10):
    print ("0"*n, end='')
    print (i, end='')
    for a in range (1,i):
        print (i,end='')
    print ()
    n -=1
    k +=1
