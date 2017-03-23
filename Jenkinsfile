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
    sh 'sudo /etc/init.d/blogservice stop || true'
    // copy file to target location
    sh 'cp target/*.jar /tmp/'
    // start the application
    sh 'sudo /etc/init.d/blogservice start'
    // wait for application to respond
    sh 'while ! httping -qc1 http://localhost:3500/articles ; do sleep 1 ; done'
}