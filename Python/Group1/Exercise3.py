import math
sideOne = float(input("Please, input length for side one:"))
sideTwo = float(input("Please, input length for side two:"))
sideThree = float(input("Please, input length for side three:"))
area = (1/4)* math.sqrt((sideOne+sideTwo+sideThree)*(-sideOne+sideTwo+sideThree)*(sideOne-sideTwo+sideThree)*(sideOne+sideTwo-sideThree))
print ("The area of your triangle is",area,".")
