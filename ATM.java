import java.io.*;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class ATM{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    String fname;
    String dob;
    String Gender;
    String Gender1="M";
    String Gender2="m";
    String Gender3="F";
    String Gender4="f";
    String User_Name;
    String Account_Number;
    String Password;
    String Pin;
    String Phone_Number;
    String Transaction_History="YOUR TRANSICTION HISTORY: \n";
    Scanner input=new Scanner(System.in);
    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    LocalDateTime now =LocalDateTime.now();
    float Balance=0f;
    int Transactions=0;
    public void View_Profile(){
	    System.out.println(ANSI_YELLOW+"\n\n\t\t\t<------------YOUR PROFILE-------------> \n");
	    System.out.println("\nFULL NAME:- "+ANSI_RESET+ANSI_GREEN+this.fname+ANSI_RESET+ANSI_YELLOW);
	    System.out.println("DATE OF BIRTH :- "+ANSI_RESET+ANSI_GREEN+this.dob+ANSI_RESET+ANSI_YELLOW);
	    System.out.println("GENDER :- "+ANSI_RESET+ANSI_GREEN+this.Gender+ANSI_RESET+ANSI_YELLOW);
	    System.out.println("USERNAME :- "+ANSI_RESET+ANSI_GREEN+this.User_Name+ANSI_RESET+ANSI_YELLOW);
	    System.out.println("PASSWORD :- "+ANSI_RESET+ANSI_GREEN+this.Password+ANSI_RESET+ANSI_YELLOW);
	    System.out.println("ACCOUNT NUMBER :- "+ANSI_RESET+ANSI_GREEN+this.Account_Number+ANSI_RESET+ANSI_YELLOW);
	    System.out.println("4-DIGIT PIN :- "+ANSI_RESET+ANSI_GREEN+this.Pin+ANSI_RESET+ANSI_YELLOW);
	    System.out.println("PHONE NUMBER :- "+ANSI_RESET+ANSI_GREEN+this.Phone_Number+ANSI_RESET+ANSI_YELLOW);
	}
    public void Register(){
        System.out.println(ANSI_YELLOW+"\n\n\t\t\t<----------------- NEW USER REGISTRATION ----------------->");
        System.out.print("\nENTER YOUR NAME :- "+ANSI_RESET+ANSI_GREEN);
        this.fname=input.nextLine();
        System.out.print(ANSI_YELLOW+"ENTER DOB(dd/mm/yyyy) :- "+ANSI_RESET+ANSI_GREEN);
        this.dob=input.nextLine();
        System.out.print(ANSI_YELLOW+"ENTER GENDER(M/F) :- "+ANSI_RESET+ANSI_GREEN);
        this.Gender=input.nextLine();
        while(!((((this.Gender).equals(this.Gender1)) || ((this.Gender).equals(this.Gender2))) || (((this.Gender).equals(this.Gender3)) || ((this.Gender).equals(this.Gender4))))){
            System.out.print(ANSI_RED+"!!WARNING INVALID GENDER /nPLEASE ENTER THE CORRECT GENDER(M/F) :- "+ANSI_RESET+ANSI_GREEN);
            this.Gender=input.nextLine();
        }
        if(this.Gender.equals(this.Gender1) || this.Gender.equals(this.Gender2)){
            this.Gender="Male";
        }
        else{
            this.Gender="Female";
        }
        //System.out.print(this.Gender);
        System.out.print(ANSI_YELLOW+"ENTER USERNAME :- "+ANSI_RESET+ANSI_GREEN);
        this.User_Name=input.nextLine();
        System.out.print(ANSI_YELLOW+"ENTER PASSWORD :- "+ANSI_RESET+ANSI_GREEN);
        this.Password=input.nextLine();
        System.out.print(ANSI_YELLOW+"ENTER ACCOUNT NUMBER :- "+ANSI_RESET+ANSI_GREEN);
        this.Account_Number=input.nextLine();
        while((Account_Number.length())!=10){
            System.out.print(ANSI_RED+"\n!!! WARNING INVALID ACCOUNT NUMBER \n "+ ANSI_RESET+ANSI_YELLOW+"PLEASE ENTER THE VALID ACCOUNT NUMBER :- "+ANSI_RESET+ANSI_GREEN);
            this.Account_Number=input.nextLine();
        }
        System.out.print(ANSI_YELLOW+"ENTER THE 4-DIGIT PIN :- "+ANSI_RESET+ANSI_GREEN);
        this.Pin=input.nextLine();
        while((Pin.length())!=4){
            System.out.print(ANSI_RED+"\n!!! WARNING INVALID PIN \n"+ ANSI_RESET+ANSI_YELLOW+ "PLEASE ENTER THE VALID PIN :- "+ANSI_RESET+ANSI_GREEN);
            this.Pin=input.nextLine();
        }
        System.out.print(ANSI_YELLOW+"ENTER THE MOBILE NUMBER :- "+ANSI_RESET+ANSI_GREEN);
        this.Phone_Number=input.nextLine();
        while((Phone_Number.length())!=10){
            System.out.print(ANSI_RED+"\n!!! WARNING INVALID MOBILE NUMBER \n"+ ANSI_RESET+ANSI_YELLOW+"PLEASE ENTER THE VALID MOBILE NUMBER :- "+ANSI_RESET+ANSI_GREEN);
            this.Phone_Number=input.nextLine();
        }
        System.out.println(ANSI_GREEN+"\n\n \t\t\tYOUR INFORMATION HAS BEEN SUCCESFULLY REGISTERD...");
        System.out.println("\t\t\tKINDLY LOGIN TO YOUR ACCOUNT TO PERFORM THE BANKING OPERATIONS"+ANSI_RESET);
        System.out.println("----------------------------------------------------------------------------------------------------------------");
    }
    public boolean Login(){
        boolean log=false;
        while(!log){
            System.out.print(ANSI_YELLOW+"PLEASE ENTER YOUR 10 DIGIT ACCOUNT NUMBER: "+ANSI_RESET+ANSI_GREEN);
            String Acct_Number;
            Acct_Number =input.nextLine();
            if (Acct_Number.equals(Account_Number)){
                System.out.print(ANSI_YELLOW+"ENTER 4 DIGIT PIN : "+ANSI_GREEN);
                String pinpass;
		pinpass=input.nextLine();
		System.out.print(ANSI_YELLOW+"CONFIRM YOUR 4 DIGIT PIN : "+ANSI_GREEN);
		String conpin;
		conpin=input.nextLine();
		if(conpin.equals(pinpass)){
                	while(!log){
                    	if(pinpass.equals(Pin)){
                        	System.out.println(ANSI_GREEN+"LOGGED IN SUCCESFULLY!!"+ANSI_RESET);
                        	log=true;
                    	}
                    	else{
                        	System.out.println(ANSI_RED+"ENTER CORRECT PIN!!"+ANSI_GREEN);
                        	break;
                    	}
                	}
		}
		else{
			System.out.println(ANSI_RED+"PLEASE ENTER THE SAME PIN TWICE"+ANSI_RESET);
		}
            } 
            else{
                System.out.println(ANSI_YELLOW+"REGISTER TO LOGIN..."+ANSI_RESET);
            }
            System.out.println("----------------------------------------------------------------------------------------");
        }
        return log;
    }
    public void Deposit(){
        System.out.print(ANSI_YELLOW+"\n\n\t\tENTER THE AMOUNT TO BE ENTERED : "+ANSI_GREEN);
        float Deposit_Amount;
        Deposit_Amount=input.nextFloat();
        if(Deposit_Amount>500000f){
            System.out.println(ANSI_RED+"\nTHIS ATM IS NOT CAPABLE TO DEPOSIT MONEY BEYOND 5,00,000/-"+ANSI_GREEN);
        }
        else{
            Balance=Balance+Deposit_Amount;
            Transactions=Transactions+1;
            System.out.println(ANSI_YELLOW+"\n\t\tSUCCESFULLY DEPOSITED Rs. "+ANSI_GREEN+Deposit_Amount+ANSI_YELLOW+" INTO YOUR ACCOUNT "+dtf.format(now));
            System.out.println("\t\tYOUR CURRENT BALANCE AFTER THIS TRANSSICTION IS: "+ANSI_YELLOW+Balance);
            String History=" ";
            History="\n        Rs "+Deposit_Amount+" DEPOSITED AT "+dtf.format(now)+" .\n";
            Transaction_History=Transaction_History.concat(History);
        }
        System.out.println("----------------------------------------------------------------------------------------");
    }
    public void Withdraw(){
        System.out.print(ANSI_YELLOW+"\n\n\tEnter amount to withdraw from your account : "+ANSI_GREEN);
        float Withdraw_Amount;
        Withdraw_Amount=input.nextFloat();
        if(Withdraw_Amount<500000){
            if (Withdraw_Amount>Balance){
                System.out.println(ANSI_RED+"\tSorry! Insufficient Balance..."+ANSI_GREEN);
            }
            else{
                Balance=Balance-Withdraw_Amount;
                Transactions=Transactions+1;
                System.out.println(ANSI_YELLOW+"\n\n\t\tSUCCESFULLY WITHDRAWN Rs. "+ANSI_GREEN+Withdraw_Amount+ANSI_YELLOW+" FROM THE ACCOUNT "+dtf.format(now));
                System.out.println(ANSI_YELLOW+"\t\tYOUR CURRENT BALANCE AFTER TRANSUCTION : "+ANSI_GREEN+Balance);
                String History=" "; 
                History="\n Rs "+Withdraw_Amount+" WITHDRAWN AT "+dtf.format(now)+" .\n";
                Transaction_History=Transaction_History.concat(History);
            }
        }
        else{
            System.out.println(ANSI_RED+"THIS ATM CANNOT DISPENCE MONEY MORE THAN 5,00,000/-"+ANSI_GREEN);
        }
        System.out.println("----------------------------------------------------------------------------------------");
    }
    public void Transfer(){
        Scanner input=new Scanner(System.in);
    	System.out.print(ANSI_YELLOW+"ENTER THE USERNAME TO TRANSFER : "+ANSI_GREEN);
        String Usertotransfer;
        Usertotransfer=input.nextLine();
        System.out.print(ANSI_YELLOW+"ENTER THE AMOUNT TO TRANSFER TO "+ANSI_GREEN+Usertotransfer+" : ");
        float Total_Amount;
        Total_Amount=input.nextFloat();
        if(Total_Amount<500000f){
            if (Total_Amount>Balance){
                System.out.println(ANSI_RED+"\n\tSORRY! AMOUNT CANT BE TRANSFERRED DUE TO INSUFFICIENT BALANCE."+ANSI_RESET);
                System.out.println(ANSI_YELLOW+"\tYOUR BALANCE WAS: "+Balance);
            }
            else{
                Balance=Balance-Total_Amount;
                Transactions=Transactions+1;
                System.out.println(ANSI_YELLOW+"\n\n\tSUCCESSFULLY TRANSFERRED Rs. "+ANSI_GREEN+Total_Amount+ANSI_YELLOW+" TO "+Usertotransfer+" FROM YOUR ACCOUNT AT "+dtf.format(now));
                System.out.println("\tYOUR CURRENT BALANCE AFTER THIS TRANSICTION IS : "+Balance);
                String History=" "; 
                History="\n Rs "+Total_Amount+" WAS TRANSFERRED TO  "+Usertotransfer+"'S ACCOUNT FROM YOUR ACCONT AT  "+dtf.format(now)+" .\n";
                Transaction_History=Transaction_History.concat(History);
            }
        }
        else{
            System.out.println(ANSI_RED+"\nCANNOT TRANSFER MONEY BEYOND 5,00,000/-"+ANSI_YELLOW);
        }
        System.out.println("----------------------------------------------------------------------------------------");
    }
    public void Transaction_history(){
        System.out.println("----------------------------------------------------------------------------------------");
        if(Transactions==0){
            System.out.println(ANSI_RED+"\nNO TRANSICTION ");
        }
        else{
            System.out.println(ANSI_YELLOW+"\n"+Transaction_History);
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }
    public void Check_Balance(){
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println(ANSI_YELLOW+"\nBALANCE AMOUNT IS : "+ANSI_GREEN+Balance);
        System.out.println("----------------------------------------------------------------------------------------");
    }
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        System.out.println(ANSI_YELLOW+"<----------------------- WELCOME TO OASIS ATM  ----------------------->"+ANSI_RESET);
        System.out.println(ANSI_YELLOW+"\nSELECT ANY ONE OF THE OPTION FROM BELOW :-");
        System.out.println(ANSI_YELLOW+"1] REGISTER (NEW USERS SHOULD REGISTER FIRST)\n2] EXIT");
        System.out.print("ENTER YOUR CHOICE:"+ANSI_RESET+ANSI_PURPLE+ANSI_RESET);
        int choice;
        choice=input.nextInt();
        if(choice==1){
            ATM atm=new ATM();
            atm.Register();
            while(choice==1){
                System.out.println(ANSI_YELLOW+"\n SELECT ANY ONE OF THE OPTION FROM BELOW : ");
                System.out.println("1] LOGIN(IF ALREDY REGISTERD)\n2] EXIT");
                System.out.print("YOUR OPTION :"+ANSI_RESET+ANSI_PURPLE+ANSI_RESET);
                int option=input.nextInt();
                if (option==1){
                    if(atm.Login()){
                        while(true){
                            System.out.println(ANSI_RESET+"----------------------------------------------------------------------------------------");
                            System.out.println(ANSI_YELLOW+"\n\t\t\tTHE OPERATION YOU CAN PERFORM IN THE OASIS ATM: \n");
                            System.out.println("1.VIEW PROFILE\n2.DEPOSIT MONEY\n3.WITHDRAW MONEY\n4.TRANSFER\n5.TRANSICTION HISTORY\n6.CHECK BALANCE\n7.EXIT");
                            System.out.print("\nENTR YOUR OPTION :"+ANSI_RESET+ANSI_PURPLE+ANSI_RESET);
                            
                            
                            int select; 
                            select=input.nextInt();
                            switch(select){
                                case 1 : atm.View_Profile();
                                         break;
                                case 2 : atm.Deposit();
                                         break;
                                case 3 : atm.Withdraw();
                                         break;
                                case 4 : atm.Transfer();
                                         break;
                                case 5 : atm.Transaction_history();
                                         break;
                                case 6 : atm.Check_Balance();
                                         break;
                                case 7 :System.out.println(ANSI_GREEN+"\n\n\t\t\tTHANK YOU...VISIT AGAIN...:)"+ANSI_RESET); 
                                        System.exit(0);
                                default: System.out.println(ANSI_RED+"INVALID OPTION!...ENTER VALID OPTION..."+ANSI_RESET);
                            }
                        }
                    }
                }
                else{
                    System.out.println(ANSI_GREEN+"\n\n\t\t\tTHANK YOU...Visit AGAIN...:)\n\n"+ANSI_RESET); 
                    System.exit(0);
                }
            }
        }
        else {
            System.out.println(ANSI_GREEN+"\n\n\t\t\tTHANK YOU...Visit AGAIN...:)\n\n"+ANSI_RESET); 
        	System.exit(0);
        }
    }
}
