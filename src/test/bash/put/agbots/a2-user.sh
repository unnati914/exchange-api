# Adds agbot a2
source `dirname $0`/../../functions.sh '' '' $*

curl $copts -X PUT -H 'Content-Type: application/json' -H 'Accept: application/json' -H "Authorization:Basic $EXCHANGE_ORG/$EXCHANGE_USER:$EXCHANGE_PW" -d '{
  "token": "abcdef",
  "name": "agbot2",
  "msgEndPoint": "whisper-id",
  "publicKey": "AGBOTDEF"
}' $EXCHANGE_URL_ROOT/v1/orgs/$EXCHANGE_ORG/agbots/a2 | $parse
