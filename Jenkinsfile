node{
    stage 'Build'
    sh "ng build --prod"
}

node{
    stage 'Deploy'
    // copy file to target location
    sh 'sudo cp dist/* /var/www/blog-webapp'
}