
#!/bin/bash

BASE_URL="http://localhost:3000"
# first thing we did after creating this file is to run this command -> chmod +x test-api.sh



echo "🔹 Creating Todo..."

CREATE_RESPONSE=$(curl -s -X POST "$BASE_URL/todos" \
  -H "Content-Type: application/json" \
  -d '{"title":"Learn debugging"}')

echo "Response:"
echo "$CREATE_RESPONSE"

echo ""
echo "🔹 Fetching Todos..."

GET_RESPONSE=$(curl -s "$BASE_URL/todos")

echo "Response:"
echo "$GET_RESPONSE"




