import streamlit as st
import requests as req

# prompt = st.chat_input("Say something")

# if prompt:
#     st.write(f"You: {prompt}")

API_CHAT_URL = "http://localhost:8081/api/agents/bots" # spring boot url api

messages = st.container(height=900)
if prompt := st.chat_input("Say something"):
    messages.chat_message("user").write(prompt)
    try:
        response = req.get(API_CHAT_URL, params={"query": prompt})
        if response.status_code == 200:
            data = response.json()
            messages.chat_message("assistant").write(data['answer'])

    except req.exceptions.RequestException as e:
        messages.error(f"Request failed: {e}")
