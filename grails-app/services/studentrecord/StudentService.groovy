package studentrecord

import grails.gorm.transactions.Transactional

@Transactional
class StudentService {
    Boolean deleteStudent(id) {
        def studentIns = Student.get(id)
        Boolean status = false
        if (studentIns) {
            if (studentIns.delete(flush: true)) {
                println "Deletion successful"
                status = true
            } else {
                println "Deletion failed: ${studentIns.errors}"
                status = false
            }
        }
        return status
    }
    def saveInstance(instance) {
        if(instance){
           instance.save()
            return true
        }
        return false
    }
}
