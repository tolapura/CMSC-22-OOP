public class AccountTest {
   public static void main(String[] args) {
      // Test constructor and toString()
      Account leigh = new Account();

      // Test Setters and Getters
      leigh.setBalance(1000);
      leigh.credit(100);
      leigh.debit(100);

      System.out.println(leigh.getAccountNumber());
      System.out.println(leigh.getBalance());
      System.out.println(leigh);

      Account leigh2 = new Account(888, 100);
      leigh2.credit(0);
      leigh2.debit(100);

      System.out.println(leigh2.getAccountNumber());
      System.out.println(leigh2.getBalance());
      System.out.println(leigh2);

      Account leigh3 = new Account(9999);
      leigh2.credit(200);
      leigh2.debit(100);

      System.out.println(leigh3.getAccountNumber());
      System.out.println(leigh3.getBalance());
      System.out.println(leigh3);

   }
}
