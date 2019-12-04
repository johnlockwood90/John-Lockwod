
package project6;


public class Hashtable {
    int counter = 0;
    int count;
    int count1 = 0; int count2 = 0; int count3 = 0; int count4;
    HashNode[] table;
    HashNode head;
    HashNode prev;
    HashNode pointer;
    HashNode curr;
    final int SIZE = 101;
    
    public Hashtable(){
        table = new HashNode[SIZE];
    }
    public int length(){
        return count1 + count2 + count3 + count4;
    }
    public boolean isEmpty(){
        return counter == 0;
    }
    public boolean isFull(){
        return counter == SIZE;
    }
    public void insert(int key , String value) {
        int index = hashing(key);
        HashNode newnode = new HashNode(key, value , null, table[index]);
        
        if(table[index] == null){
            table[index] = newnode;
            pointer = table[index];
            counter++;
          if(index == 1){
              count1++;
          }
          if(index == 2){
              count2++;
          }
          if(index == 3){
              count3++;
          }
          if(index == 4){
              count4++;
          }
        }
        else if(table[index] != null){
            prev = pointer;
            curr = prev.next;
            newnode.next = curr;
            prev.next = newnode;
            pointer = newnode;
            counter++;
          if(index == 1){
              count1++;
          }
          if(index == 2){
              count2++;
          }
          if(index == 3){
              count3++;
          }
          if(index == 4){
              count4++;
          }
            }
            
    }
    private int hashing(int key){
        return key % SIZE;
    }
   public void printTable(){
       String name = null;
       for(int i = 0 ; i < SIZE;i++){
           head = table[i];
           if(table[i] != null){
             if(i == 1){
                name = "Fresher";
             }  
             if(i == 2){
                 name = "Technical Lead";
             }
             if (i == 3){
                 name = "Manager";
             }
             if(i == 4){
                 name = "Calls Pending";
             }
             System.out.print(name + " call stack ---> Caller(s): ");
             while(head != null){
               System.out.print(head.getValue() + " | ");
               head = head.next;
               
           }
             System.out.println();
           }
           
       }
   } 
   
  public boolean delete(String value){
      boolean found = false; 
      for(int i = 0 ; i < SIZE;i++){
          prev = null;
          head = table[i];
            if(table[i] != null){
            while(head != null){
                if(value.equals(head.value)){
                    found = true;
                    counter--;
                if(i == 1){
                count1--;
                }
                if(i == 2){
                count2--;
                }
                if(i == 3){
                count3--;
                }
                if(i == 4){
                count4--;
                }
                if(table[4] != null && table[4].next == null &&
                count1 == 3 && count2 == 3 && count3 == 3 ){
                table[4] = null;
                break;
                }
                if(prev != null && head.next == null){
                    prev.next = null;
                    pointer = prev;
                }
                else if(prev != null && head.next != null){
                    prev.next = head.next;
                    head = head.next;
                    pointer = head;
                }
                else if (prev == null && head.next != null){
                    table[i] = table[i].next;
                    pointer = table[i].next;
                    prev = null;
                }
                if(table[4] != null && table[4].next != null &&
                   (count1 != 3 || count2 != 3 || count3 != 3 )){
                    insert(i, get(4));
                    count4--;
                    table[4] = table[4].next;
                    pointer = table[4];
                }
                else if(table[4] != null && table[4].next == null &&
                   (count1 != 3 || count2 != 3 || count3 != 3 ) ){
                    insert(i, get(4));
                    count4--;
                    table[4] = null;
                }
                break;
                }
            prev = head;
            head = head.next;
            }
        }
      }
      return found;
    }
  public void clearStack(int key){
      if((key == 1 || key == 2 || key == 3) && table[4]==null){
          if(key == 1){
              table[key] = table[key+1];
              table[key+1] = table[key+2];
              table[key+2] = null;
              count3= 0;
          }
          if(key == 2){
              table[key] = table[key+1];
              table[key+1] = null;
              count3=0;
          }
          if(key == 3){
              table[key] = null;
              count3=0;
          }
          counter -= 3;
          count4 =0;
      }
          else if((key == 1 || key == 2 || key == 3) && table[4]!=null && count4 <= 3){
          if(key == 1){
              table[key] = table[key+1];
              table[key+1] = table[key+2];
              table[key+2] = table[key+3];
              table[key+3] = null;
              count3 =0;
              head = table[key+2];
              while(head != null){
                  count3++;
                  head = head.next;
              }
          }
          if(key == 2){
              table[key] = table[key+1];
              table[key+1] = table[key+2];
              table[key+2] = null;
              count3 = 0;
              head = table[key+1];
              while(head != null){
                  count3++;
                  head = head.next;
          }
          }
          if(key == 3){
              table[key] = table[key+1];
              table[key+1] = null;
              head = table[key];
              count3 = 0;
              while(head != null){
                  count3++;
                  head = head.next;
              }
          }
          counter = count1 + count2 +count3;
          count4 = 0;
        }
        else if((key == 1 || key == 2 || key == 3) && table[4]!=null && count4 > 3){
            if(key == 1){
              table[key] = table[key+1];
              table[key+1] = table[key+2];
              table[key+2] = null;
              count3 = 0;
              while(table[4]!= null && count3 < 3){
              insert(key+2, table[4].value);
              table[4] = table[4].next;
              count4--;
                }
            }
          if(key == 2){
              table[key] = table[key+1];
              table[key+1] = null;
              count3 = 0;
              while(table[4] != null && count3 < 3){
              insert(key+1, table[4].value);
              table[4] = table[4].next;
              count4--;
            }
          }
          if(key == 3){
              table[key] = null;
              count3 = 0;
              while(table[4] != null && count3 < 3){
              insert(key, table[4].value);
              table[4] = table[4].next;
              count4--;
                }
            }
           counter = count1 + count2 + count3 + count4;
        }
        if(count4 == 0 && count3 == 0 && key == 2){
            table[key-1] = table[key];
            table[key]= null;
            count2=0;
            counter = count1;
        }
        if(count4 == 0 && count3 == 0 && key == 1){
            table[key] = table[key+1];
            table[key]= null;
            count2=0;
            counter = count1;
        }
        if(count4 == 0 && count3 == 0 && count2 ==0 && key ==1){
            table[key] = null;
            count1 =0;
            counter = 0;
            }
        
        if(key == 4){
          table[4] = null;
          counter = count1 + count2 + count3;    
      }
  }
   
  
  public String get(int key){
      int index = hashing(key);
      head = table[index];
      if(head != null){
          return head.value;
          }
      return null;
  } 
      
  public boolean contains(String value){
      for(int i = 0 ; i < SIZE ;i++){
         head = table[i];
          while(head != null){
           if(value.equals(head.value)){
               return true;
            }
           head = head.next;
           }
     
    }
       return false;
  }

  public int waitNumber(String value){
      for(int i = 0 ; i < SIZE ;i++){
          count = 0;
          head = table[i];
          while(head != null){
           if(value.equals(head.value)){
               return count;
            }
           count++;
           head = head.next;
            }
        }
      return count;
    }
  public String getRep(String value){
      String name = null;
      for(int i = 0 ; i < SIZE ;i++){
         head = table[i];
          while(head != null){
           if(value.equals(head.value)){
               count = i;
            }
           head = head.next;
        }
          if(count == 1){
                name = "Fresher";
             }  
             if(count == 2){
                 name = "Technical Lead";
             }
             if (count == 3){
                 name = "Manager";
             }
             if(count == 4){
                 name = "Calls pending";
             } 
        }
      return name;
    }
  public int count1(){
      return count1;
  }
  public int count2(){
      return count2;
  }
  public int count3(){
      return count3;
  }
  public int count4(){
      return count4;
}
}
