package studentrecord

class SignUpController {
    static List responseFormats = ['json', 'xml']
    def studentService
    def index() { }
    def signup(){
         def sign = request.JSON
         println"----->>>>>>>>>${sign.firstname}"
         def signup=new SignUp(firstname:sign.firstname,
         lastname:sign.lastname,
         gender:sign.gender,
         password:sign.password,
         email:sign.email)
         def data
         println"====>${signup}"
         if(signup.validate()){
             def isUpdated = studentService.saveInstance(signup)
             data=["message":"signup successfully completed"]
        } else{
            println "Unsaved"
            data=["message":"signup not completed"]
        }
        respond data
    }
    def login(){

    }
}
