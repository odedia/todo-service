allow_k8s_contexts('tap-cluster')
load('.tanzu/tanzu_tilt_extensions.py', 'tanzu_k8s_yaml')

SOURCE_IMAGE = os.getenv("SOURCE_IMAGE", default='harbor.apps.cf.tanzutime.com/apps/todo-service-local')
LOCAL_PATH = os.getenv("LOCAL_PATH", default='.')

custom_build('harbor.apps.cf.tanzutime.com/apps/todo-service-local',
    "tanzu apps workload apply -f config/workload.yaml --live-update \
      --local-path " + LOCAL_PATH + " --source-image " + SOURCE_IMAGE + " --yes && \
    .tanzu/wait.sh todo-service-local",
  ['pom.xml', './target/classes'],
  live_update = [
    sync('./target/classes', '/workspace/BOOT-INF/classes')
  ],
  skips_local_docker=True
)
tanzu_k8s_yaml('todo-service-local', 'harbor.apps.cf.tanzutime.com/apps/todo-service-local', './config/workload.yaml')
