package mobilize.mx.genericadaptertest.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Posts implements Parcelable{


    public String body;
    public String title;
    public int id;
    public int userId;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.body);
        dest.writeString(this.title);
        dest.writeInt(this.id);
        dest.writeInt(this.userId);
    }

    public Posts() {
    }

    protected Posts(Parcel in) {
        this.body = in.readString();
        this.title = in.readString();
        this.id = in.readInt();
        this.userId = in.readInt();
    }

    public static final Creator<Posts> CREATOR = new Creator<Posts>() {
        @Override
        public Posts createFromParcel(Parcel source) {
            return new Posts(source);
        }

        @Override
        public Posts[] newArray(int size) {
            return new Posts[size];
        }
    };
}
