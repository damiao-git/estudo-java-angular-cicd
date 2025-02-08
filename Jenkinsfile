pipeline {
    agent any

    stages {
        stage('Checkout Código') {
            steps {
                git 'https://github.com/damiao-git/estudo-java-angular-cicd'
            }
        }
        stage('Verificar Diretório') {
            steps {
                bat 'dir'
            }
        }
        stage('Instalar Dependências') {
            steps {
                dir('backend') {
                    bat 'gradlew.bat dependencies'
                }
            }
        }
        stage('Compilar Código') {
            steps {
                dir('backend') {
                    bat 'gradlew.bat build'
                }
            }
        }
        stage('Rodar Testes') {
            steps {
                dir('backend') {
                    bat 'gradlew.bat test'
                }
            }
        }
        stage('Gerar Artefato') {
            steps {
                dir('backend') {
                    bat 'gradlew.bat assemble'
                }
            }
        }
    }
}
