#!/bin/bash

BASE_URL="http://localhost:3000"

echo "=============================="
echo "🚀 API TEST START"
echo "=============================="

echo ""
echo "🔹 Creating Todo..."

# added -s and -w things to get the status code in the response, -w for getting status code and -s 
# for silent mode to avoid progress bar and other info from curl
CREATE_RESPONSE=$(curl -s -w "\nSTATUS:%{http_code}" -X POST "$BASE_URL/todos" \
  -H "Content-Type: application/json" \
  -d '{"title":"Learn debugging"}')

echo "$CREATE_RESPONSE"

echo ""
echo "🔹 Fetching Todos..."

GET_RESPONSE=$(curl -s -w "\nSTATUS:%{http_code}" "$BASE_URL/todos")

echo "$GET_RESPONSE"

echo ""
echo "=============================="
echo "✅ API TEST END"
echo "=============================="