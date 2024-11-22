package studentrecord
class StudentController {
    static List responseFormats = ['json', 'xml']
    def studentService
    
    def save(){
        def req = request.JSON
        println"${req}"
        def studentIns=new Student(name:req.name,
        department:req.dept,
        subject1:req.mark1,
        subject2:req.mark2,
        subject3:req.mark3,
        subject4:req.mark4,
        subject5:req.mark5,
        )
        if(studentIns.validate()){
             def isUpdated = studentService.saveInstance(studentIns)
        }
        else{
            println "unsaved"
        }
        def data=[]
        def studentIns1=Student.getAll()
        for(def date:studentIns1){
            def student=["id":date.id,"name":date.name,"dept":date.department,"mark1":date.subject1,"mark2":date.subject2,"mark3":date.subject3,"mark4":date.subject4,"mark5":date.subject5]
            data<<student
        }
        respond data
    }

    def read(){
        def list=[]
        def studentIns=Student.getAll()
        for(def data:studentIns){
            def student=["id":data.id,"name":data.name,"dept":data.department,"mark1":data.subject1,"mark2":data.subject2,"mark3":data.subject3,"mark4":data.subject4,"mark5":data.subject5]
            list<<student
        }
            def data = list
            respond data
        }

    def delete(){     
        def req =params?.id
        def userDetailsIns = Student.get(req?.toLong())
        if(req){
            def result = studentService.deleteStudent(req)
            if(result==true){
               println "result==>deleted successfully"
            }else{
                println"result===>deleted unsuccessfully"
            }
        }
        def data=[]
        def studentIns=Student.getAll()
        for(def date:studentIns){
            def student=["id":date.id,"name":date.name,"dept":date.department,"mark1":date.subject1,"mark2":date.subject2,"mark3":date.subject3,"mark4":date.subject4,"mark5":date.subject5]
            data<<student
        }
      respond data
  }

  def update(){
    def requestJSON=request.JSON
    def studentIns=Student.createCriteria().get(){
        eq("id",requestJSON.id?.toLong())
    }
    studentIns?.name = requestJSON.name
    studentIns?.department = requestJSON.dept   
    studentIns?.subject1 = requestJSON.mark1?.toLong()
    studentIns?.subject2 = requestJSON.mark2?.toLong()
    studentIns?.subject3 = requestJSON.mark3?.toLong()
    studentIns?.subject4 = requestJSON.mark4?.toLong()
    studentIns?.subject5 = requestJSON.mark5?.toLong()
    def isUpdated = studentService.saveInstance(studentIns)
    def list = []
    def studentInsList=Student.getAll()
        for(def date:studentInsList){
            def student=["id":date.id,"name":date.name,"dept":date.department,"mark1":date.subject1,"mark2":date.subject2,"mark3":date.subject3,"mark4":date.subject4,"mark5":date.subject5]
            list<<student
        }
        def data=list
    respond data
  }
}