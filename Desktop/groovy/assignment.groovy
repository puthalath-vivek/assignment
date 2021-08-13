String filepath = "/home/tracxn-lp-455/Desktop/groovy/input.txt"

String[] name = []
def batsmanscore=[]
def bowlerscore=[]
def allrounderescore=[]
def batsman=[]
def bowler=[]
def allrounder=[]

File myFile = new File(filepath)
def list = myFile.collect{it}
String positions = list[0].toString().split('=')[1]
position1 = positions.split(',')[0]  //Batsman
position2 = positions.split(',')[1]  //Bowler
position3 = positions.split(',')[2]  //Allrounder

int j=0
int k=0
int l=0
for (i in 3..list.size()-1)
{
    list[i].toString()
    list[i]=list[i].split(',')
//    println("list[i][1]="+list[i][1]+","+"list[i][2]="+list[i][2]+"list[i][3]="+list[i][3])
    switch (list[i][1])
    {
        case position1:
            batsmanscore[j]=(list[i][2].toFloat()*list[i][3].toFloat())
            batsman[j]=[list[i][0],batsmanscore[j]]
            j++
            break
        case position2:
            bowlerscore[k]=10000/(list[i][4].toFloat()*list[i][5].toFloat())
            bowler[k]=  [list[i][0],bowlerscore[k]]
            k++
            break
        case position3:
            allrounderescore[l] = (list[i][2].toFloat()*list[i][3].toFloat())*(10000/(list[i][4].toFloat()*list[i][5].toFloat()))
            allrounder[l] = [list[i][0],allrounderescore[l]]
            l++
            break
    }

}
bubbleSort(batsman)
bubbleSort(bowler)
bubbleSort(allrounder)
println("Batsman "+batsman[0][0]+" "+batsman[1][0])
println("Bowler "+bowler[0][0]+" "+bowler[1][0])
println("Allrounder "+allrounder[0][0])

static void bubbleSort(def  arr ) {
    int n = arr.size()
    def temp = []
    for (int i = 0; i < n; i++) {
        for (int j = 1; j < (n - i); j++) {
            if (arr[j - 1][1] < arr[j][1]) {
                //swap elements
                temp = arr[j - 1]
                arr[j - 1] = arr[j]
                arr[j] = temp
            }

        }
    }
}


