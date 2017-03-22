node{
    stage 'Build, Test and Package'
    env.PATH = "${tool 'M3'}/bin:${env.PATH}"
    git url: "https://github.com/haksunkim/blog-service.git"
    // workaround, taken from https://github.com/jenkinsci/pipeline-examples/blob/master/pipeline-examples/gitcommit/gitcommit.groovy
    def commitid = sh(returnStdout: true, script: 'git rev-parse HEAD').trim()
    def workspacePath = pwd()
    sh "echo ${commitid} > ${workspacePath}/expectedCommitid.txt"
    sh "mvn clean package -Dcommitid=${commitid}"
}

node{
    stage 'Stop, Deploy and Start'
    // shutdown
    // sh 'curl -X POST http://localhost:10000/shutdown || true'
    // copy file to target location
    sh 'cp target/*.jar /tmp/'
    // start the application
    //sh 'nohup java -jar /tmp/*.jar &'
    // wait for application to respond
    //sh 'while ! httping -qc1 http://localhost:10000 ; do sleep 1 ; done'
}