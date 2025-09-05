public class assQ1{
    void ttheft(int[] arr,int k){
        int total=0;
        for(int j=0;j<k;j++){
            int x=arr[0],ind=0;
            for(int i=0;i<arr.length;i++){
                if(x<arr[i] && arr[i]!=-1){
                    x=arr[i];
                    ind=i;
                }
            }
            total+=x;
            arr[ind]=-1;
        }
        System.out.println(total);
    }
    public static void main(String args[]){
        assQ1 o=new assQ1();
        int[] arr = {2,7,8,10,4,1,3};
        int k=4;
        o.ttheft(arr,k);
    }
}