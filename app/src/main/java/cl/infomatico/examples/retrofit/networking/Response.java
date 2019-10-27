package cl.infomatico.examples.retrofit.networking;

import com.google.gson.annotations.SerializedName;

public class Response {
    // region Id

    @SerializedName("id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // endregion
}