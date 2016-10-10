
import random
import sys
sys.version


n = input('Enter the size of the graph :')
n= int(n)
i=0
walls=[]
while i==0 :
    wall_x = input ('Enter the walls of the graph(x)[if you want to stop enter "exit"] :')
    if (wall_x=="exit"):
            i=1
    else:
        wall_y = input ('Enter the walls of the graph(y):')
        wall_x=int(wall_x)
        wall_y=int(wall_y)
        walls.append([wall_x,wall_y])
#print (walls)
graph1 = {}
test=[]
k=0
print (walls)
for i in range(0,n):
    for j in range(0, n):
        neighbours = []
        test.append([i,j])
        #print (test, walls)
        #Isagogi gitonon goniakon komvon kai aferesi walls apo tixous
        if (i == 0 and j == 0):
            flag="false"
            for p in range(0,len(walls)):
                if (test[k]== walls[p]):
                    flag="true"
            if (flag=="false"):
                neighbours.append ([0,1])
            flag="false"
            for p in range(0,len(walls)):
                if (test[k]== walls[p]):
                    flag="true"
            if (flag=="false"):
                neighbours.append ([1,0])
            graph1[(i,j)] = neighbours
        elif (i == 0 and j == n-1):
            flag="false"
            for p in range(0,len(walls)):
                if (test[k]== walls[p]):
                    flag="true"
            if (flag=="false"):
                neighbours.append ([0,j-1])
            flag="false"
            for p in range(0,len(walls)):
                if (test[k]== walls[p]):
                    flag="true"
            if (flag=="false"):
                neighbours.append ([1,j])
            graph1[(i,j)] = neighbours
        elif (i == n-1 and j == 0):
            flag="false"
            for p in range(0,len(walls)):
                if (test[k]== walls[p]):
                    flag="true"
            if (flag=="false"):
                neighbours.append ([i-1,0])
            flag="false"
            for p in range(0,len(walls)):
                if (test[k]== walls[p]):
                    flag="true"
            if (flag=="false"):
                neighbours.append ([i,1])
            graph1[(i,j)] = neighbours
        elif (i == n-1 and j == n-1):
            flag="false"
            for p in range(0,len(walls)):
                if (test[k]== walls[p]):
                    flag="true"
            if (flag=="false"):
                neighbours.append ([i,j-1])
            flag="false"
            for p in range(0,len(walls)):
                if (test[k]== walls[p]):
                    flag="true"
            if (flag=="false"):
                neighbours.append ([i-1,j])
            graph1[(i,j)] = neighbours
        #Isagogi gitonon perimetrikon komvon kai aferesi walls apo tixous
        elif (i == 0 and not(j == 0) and not(j == n-1)):
            flag="false"
            for p in range(0,len(walls)):
                if (test[k]== walls[p]):
                    flag="true"
            if (flag=="false"):
                neighbours.append ([i,j-1])
            flag="false"
            for p in range(0,len(walls)):
                if (test[k]== walls[p]):
                    flag="true"
            if (flag=="false"):
                neighbours.append ([i,j+1])
            flag="false"
            for p in range(0,len(walls)):
                if (test[k]== walls[p]):
                    flag="true"
            if (flag=="false"):
                neighbours.append ([i+1,j])
            graph1[(i,j)] = neighbours
        elif (j == 0 and not(i == 0) and not(i == n-1)):
            flag="false"
            for p in range(0,len(walls)):
                if (test[k]== walls[p]):
                    flag="true"
            if (flag=="false"):
                neighbours.append ([i-1,j])
            flag="false"
            for p in range(0,len(walls)):
                if (test[k]== walls[p]):
                    flag="true"
            if (flag=="false"):
                neighbours.append ([i,j+1])
            flag="false"
            for p in range(0,len(walls)):
                if (test[k]== walls[p]):
                    flag="true"
            if (flag=="false"):
                neighbours.append ([i+1,j])
            graph1[(i,j)] = neighbours
        elif (i == n-1 and not(j == 0) and not(j == n-1)):
            flag="false"
            for p in range(0,len(walls)):
                if (test[k]== walls[p]):
                    flag="true"
            if (flag=="false"):
                neighbours.append ([i,j-1])
            flag="false"
            for p in range(0,len(walls)):
                if (test[k]== walls[p]):
                    flag="true"
            if (flag=="false"):
                neighbours.append ([i,j+1])
            flag="false"
            for p in range(0,len(walls)):
                if (test[k]== walls[p]):
                    flag="true"
            if (flag=="false"):
                neighbours.append ([i-1,j])
            graph1[(i,j)] = neighbours
        elif (j == n-1 and not(i == 0) and not(i == n-1)):
            flag="false"
            for p in range(0,len(walls)):
                if (test[k]== walls[p]):
                    flag="true"
            if (flag=="false"):
                neighbours.append ([i,j-1])
            flag="false"
            for p in range(0,len(walls)):
                if (test[k]== walls[p]):
                    flag="true"
            if (flag=="false"):
                neighbours.append ([i+1,j])
            flag="false"
            for p in range(0,len(walls)):
                if (test[k]== walls[p]):
                    flag="true"
            if (flag=="false"):
                neighbours.append ([i-1,j])
            graph1[(i,j)] = neighbours
        #Isagogi gitonon kentrikon komvon kai aferesi walls apo tixous
        else:
                flag="false"
                for p in range(0,len(walls)):
                    if (test[k]== walls[p]):
                        flag="true"
                if (flag=="false"):
                    neighbours.append ([i,j+1])
                flag="false"
                for p in range(0,len(walls)):
                    if (test[k]== walls[p]):
                        flag="true"
                if (flag=="false"):
                    neighbours.append ([i,j-1])
                flag="false"
                for p in range(0,len(walls)):
                    if (test[k]== walls[p]):
                        flag="true"
                if (flag=="false"):
                    neighbours.append ([i+1,j])
                flag="false"
                for p in range(0,len(walls)):
                    if (test[k]== walls[p]):
                        flag="true"
                if (flag=="false"):
                    neighbours.append ([i-1,j])
                graph1[(i,j)] = neighbours
        k+=1


#print (neighbours,walls)

#Isagogi metavliton ekinisis kai goal
start_x = input('Enter the starting x coordinate ): ')
start_x= int(start_x)
while (start_x<0 or start_x>=n):
    start_x = input('Enter again the the starting x coordinate: ')
    start_x= int(start_x)

start_y = input('Enter the starting y coordinate ): ')
start_y= int(start_y)
while (start_y<0 or start_y>=n):
    start_y = input('Enter again the the starting y coordinate: ')
    start_y= int(start_y)

end_x = input('Enter the goal x coordinate ): ')
end_x= int(end_x)
while (end_x<0 or end_x>=n):
    end_x = input('Enter again the the goal x coordinate: ')
    end_x= int(end_x)

end_y = input('Enter the goal y coordinate ): ')
end_y= int(end_y)
while (end_y<0 or end_y>=n):
    end_y = input('Enter again the the goal y coordinate: ')
    end_y= int(end_y)

#To visited hrisimopiite gia na elenghoume an ehoume episkefthei ton ekastote komvo
visited = {}
for i in range(0,n):
    for j in range(0,n):
        visited[(i,j)] = 0

#ston maze katagrafoume tous komvous pou diashizoume kata tin anazitisi tou grafou
maze = []


def DFS(sx,sy,fx,fy):

    visited[(sx,sy)] = 1
    #vazw stn maze ts komvous
    maze.append((sx,sy))

    #stin AdjacencyList katagrafonte oi gitones tou ekastote komvou
    AdjacencyList = graph1[(sx,sy)]

    random_neighbour = random.sample(AdjacencyList, len(AdjacencyList))

    #print (random_neighbour)
    #gia kathe stihio tis anakatemenis listas elenghoume to visited kai an den ehoume episkefti ton komvo ksanakaloume tin methodo
    for index in range(len(random_neighbour)):
        a = random_neighbour[index]
        sx = a[0]
        sy = a[1]

        if (visited[(sx,sy)]==0):
            if (sx==fx and sx==sy):
                maze.append((sx,sy))
                break
            else:
                DFS(sx,sy,fx,fy)



#kaloume tin methodo me tis metavlites ekinisis
DFS(start_x,start_y,end_x,end_y)

#tipono ton maze gia na do tin poria pou akolouthisame kata tin anazitisi tou grafou
print(maze)
