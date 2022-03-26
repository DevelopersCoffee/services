#!/bin/bash
#variables
PROJECT=<PROJECT_ID>

#get all the repositories
gcloud source repos list  --project=$PROJECT --format="value(name, URL)" | 
#create triggers for all the repository
# reference : https://cloud.google.com/sdk/gcloud/reference/beta/builds/triggers/create/cloud-source-repositories#--substitutions
while read name url 
do
    basename=$(basename $url)
    servicename=${basename%.*}
    gcloud beta builds triggers create cloud-source-repositories --name=$servicename-BUILD --repo=$name --branch-pattern=^main$ --build-config=cloudbuild.yml
done
