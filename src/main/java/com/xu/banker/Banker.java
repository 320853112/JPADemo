package com.xu.banker;

public class Banker {
    private final Integer[][] maxRequest= new Integer[5][3];

    private final Integer[][] allocation = new Integer[5][3];

    private final Integer[][] need= new Integer[5][3];

    private final Integer[] available = new Integer[3];

    private final Integer[] request = new Integer[3];

    private final boolean[] state = new boolean[]{false,false,false,false,false};

    private void initMaxRequest(){
        maxRequest[0] = new Integer[]{7,5,3};
        maxRequest[1] = new Integer[]{3,2,2};
        maxRequest[2] = new Integer[]{9,0,2};
        maxRequest[3] = new Integer[]{2,2,2};
        maxRequest[4] = new Integer[]{4,3,3};
    }

    private void initAllocation(){
        allocation[0] = new Integer[]{0,1,0};
        allocation[1] = new Integer[]{2,0,0};
        allocation[2] = new Integer[]{3,0,2};
        allocation[3] = new Integer[]{2,1,1};
        allocation[4] = new Integer[]{0,0,2};
    }

    private void initNeed(){
        need[0] = new Integer[]{7,4,3};
        need[1] = new Integer[]{1,2,2};
        need[2] = new Integer[]{6,0,0};
        need[3] = new Integer[]{0,1,1};
        need[4] = new Integer[]{4,3,1};
    }

    private void initAvailable(){
        available[0] = 3;
        available[1] = 2;
        available[2] = 2;
    }

    private boolean checkState(){
        for (int i = 0; i < 5; i++) {

            state[i];
        }
    }

    private boolean checkRequest(Integer[] request,Integer requestObject){
        //空闲资源不满足需求
        if(compare(request,available)) return false;
        //资源申请是否超过了需求上线
        if(compare(request,need[requestObject])) return false;
        add(allocation[requestObject],request);
        sub(need[requestObject],request);
        sub(available,request);
        for (int i = 0; i < 5; i++) {
            if(compare(available,need[i])){
                return checkRequest(need[i],i);
            }
        }
        //恢复
        sub(allocation[requestObject],request);
        add(need[requestObject],request);
        add(available,request);
        return false;


    }

    private boolean compare(Integer[] a,Integer[] b){
        for (int i = 0; i < 3; i++) {
            if(a[i]<b[i]) return false;
        }
        return true;
    }

    private void sub(Integer[] a,Integer[] b){
        for (int i = 0; i < 3; i++) {
            a[i] = a[i] - b[i];
        }
    }

    private void add(Integer[] a,Integer[] b){
        for (int i = 0; i < 3; i++) {
            a[i] = a[i] + b[i];
        }
    }

    public static void main(String[] args) {

    }



}
