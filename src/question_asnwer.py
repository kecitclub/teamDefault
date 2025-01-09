import os
from mistralai import Mistral

api_key = "dj5C7IMYOA3eFOskmkuuM9xdy7mbD8UO"

def generate_fun_qa_from_context(context, api_key=api_key, model="open-mistral-7b"):
    """
    Generates a fun question and answer for children based on the provided context.

    Parameters:
    - context (str): The input context paragraph.
    - api_key (str): The API key for the Mistral client.
    - model (str): The model to use for the Mistral API (default: "open-mistral-7b").

    Returns:
    - str: The generated question and answer.
    """
    # Initialize the Mistral client
    client = Mistral(api_key=api_key)

    # Create a prompt for fun QA generation
    prompt = f"""
    Read the following paragraph and create a fun question for children and provide the answer yourself too:

    Paragraph: "{context}"

    Question: What is something fun we can learn from this paragraph?
    Answer:
    """

    # Make the API call
    chat_response = client.chat.complete(
        model=model,
        messages=[
            {
                "role": "user",
                "content": prompt,
            },
        ]
    )

    # Return the generated question and answer
    return chat_response.choices[0].message.content


# paragraph = """
# The Crow’s Message (Kaag Tihar)
# A long, long time ago, there was a clever crow named Kalu. He loved watching over the villagers, and whenever danger was near, he would caw loudly to warn them. One day, a big storm was coming, and Kalu flew around the village, shouting, "Caw! Caw! Protect your crops! A storm is coming!"
# The villagers listened to Kalu, saved their crops, and were very thankful. From that day on, people began to feed crows during Kaag Tihar to thank them for being the messengers of the gods.
# """
# qa_output = generate_fun_qa_from_context(paragraph, api_key)
# print(qa_output)
    