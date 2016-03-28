interface ApprovalInterface{
  public void getApproval(int approvalConst);
}

class TeamLead implements ApprovalInterface {
  final int TL_CONST = 1 ;
  ApprovalInterface successor;

  public TeamLead(ApprovalInterface p){
     successor = p;
  }

  public void getApproval(int approvalConst){
     if (approvalConst != TL_CONST){
    	 successor.getApproval(TL_CONST);
     }
  else {
      System.out.println("Sorry about that! I am on holiday now");
     }
  }
}
class Manager implements ApprovalInterface {
  public Manager(){
  }
  public void getApproval(int approvalConst){
	  System.out.println( "Approved by manager! Sorry to make you wait ");
  }
}

public class OOD1 {   public static void main(String args[]){
   final int TL_CONST = 1;
   final int OTHER_CONST = 2;
   
   ApprovalInterface manager = new Manager();//.getApproval(TL_CONST);
   TeamLead teamLead = new TeamLead(manager);
   
   teamLead.getApproval(OTHER_CONST);
}
}