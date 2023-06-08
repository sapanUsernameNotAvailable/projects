#curl 'http://localhost:3000/register?name=nameVal&pwd=pwdVal'
#curl 'http://localhost:3000/traverse?path=/'
#curl 'http://localhost:3000/display?path=/opt/homebrew/bin/node' --output -
#curl 'http://localhost:3000/processes'
curl 'http://localhost:3000/login?name=nameVal&pwd=pwdVal'
curl --header "Content-Type: application/json" \
     --request POST \
     --data '{"content":"message content"}' \
    'http://localhost:3000/message?to=nameVal'

curl 'http://localhost:3000/messages?user=nameVal&token=810e0fb2-4bf6-4036-9469-c5f5dab61c7f'