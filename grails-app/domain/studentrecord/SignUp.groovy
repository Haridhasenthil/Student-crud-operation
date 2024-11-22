package studentrecord

class SignUp {
    String firstname; 
    String lastname;
    String gender;
    String email;
    String password;
      static constraints={
        firstname(nullable:false)
        lastname(nullable:true)
        gender(nullable:false,unique:true)
        email(nullable:false)
        password(nullable:false)
        }
}
