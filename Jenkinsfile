pipeline {
	agent any

	environment {

			AWS_ACCESS_KEY_ID     = credentials('aws-secret-key-id')
  			AWS_SECRET_ACCESS_KEY = credentials('aws-secret-access-key')

  			AWS_S3_BUCKET         = "goldenwaste-artifacts"
  			AWS_REGION            = "us-east-1"
 		 	ARTIFACT_NAME         = "ROOT.war"

  			SONAR_PROJECT_KEY     = "goldenwaste-sda-hackathon"
  			SONAR_IP              = "52.23.193.18"
  			SONAR_TOKEN           = "sqp_372a3a6d9996be621fed718e863db09228e4d344"
	}

	stages {

		
		stage('Validate') {
			steps {
				sh "mvn validate"
				sh "mvn clean"
			}
		}

		stage('Build') {
			steps {
				sh "mvn compile"
			}
		}

		stage('Test') {
			steps {
				sh "mvn test"
			}

			post {
				always {
					junit '**/target/surefire-reports/TEST-*.xml'
				}
			}
		}

		stage('Quality Scan'){

			steps {
		 		sh '''
		 			mvn clean verify sonar:sonar \
               -Dsonar.projectKey=$SONAR_PROJECT_KEY \
               -Dsonar.host.url=http://$SONAR_IP \
               -Dsonar.login=$SONAR_TOKEN
		  		'''
		 	}
		}

		

		stage('Publish artefacts to S3 Bucket') {
			steps {
				sh "aws configure set region $AWS_REGION"
				sh "aws s3 cp ./target/**.war s3://$AWS_S3_BUCKET/$ARTIFACT_NAME"
			}
		}
	}
}