from llama_index.embeddings.huggingface import HuggingFaceEmbedding
from llama_index.core import Settings, SimpleDirectoryReader, VectorStoreIndex
from llama_index.core.retrievers import VectorIndexRetriever
from llama_index.core.query_engine import RetrieverQueryEngine
from llama_index.core.postprocessor import SimilarityPostprocessor

# Specify the document path
document_path = "D:\\teamDefault\\documents"

# Load documents
documents = SimpleDirectoryReader(document_path).load_data()

# Create the embedding model
embed_model = HuggingFaceEmbedding(model_name="BAAI/bge-small-en-v1.5")

# Configure settings for the embedding model
Settings.embed_model = embed_model
Settings.llm = None

# Create the index
index = VectorStoreIndex.from_documents(documents)

def get_context_from_query(query, chunk_size=256, chunk_overlap=25, top_k=1, similarity_cutoff=0.5):
    """
    Retrieve context based on the query.
    """
    # Configure chunking settings
    Settings.chunk_size = chunk_size
    Settings.chunk_overlap = chunk_overlap

    # Configure retriever
    retriever = VectorIndexRetriever(
        index=index,
        similarity_top_k=top_k,
    )

    # Assemble query engine
    query_engine = RetrieverQueryEngine(
        retriever=retriever,
        node_postprocessors=[SimilarityPostprocessor(similarity_cutoff=similarity_cutoff)],
    )

    # Query documents
    response = query_engine.query(query)

    # Reformat response
    context = "Context:\n"
    for i in range(min(top_k, len(response.source_nodes))):
        context += response.source_nodes[i].text + "\n\n"

    return context


query = "What is Dashain?"
result_context = get_context_from_query(query, document_path)
print(result_context)




