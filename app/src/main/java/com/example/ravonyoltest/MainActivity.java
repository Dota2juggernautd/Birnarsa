package com.example.ravonyoltest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.EntityIterator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int pic_id = 123;
    // Define the button and imageview type variable
    Button camera_open_id;
    EditText description;
    ImageView click_image_id;

    Button BSelectImage, BsendImage;
    int SELECT_PICTURE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // By ID we can get each component which id is assigned in XML file get Buttons and imageview.
        BsendImage = findViewById(R.id.sendImage);
        camera_open_id = findViewById(R.id.camera_button);
        click_image_id = findViewById(R.id.click_image);
        BSelectImage = findViewById(R.id.BSelectImage);
        description = findViewById(R.id.description);

        // Camera_open button is for open the camera and add the setOnClickListener in this button
        camera_open_id.setOnClickListener(v -> {
            // Create the camera_intent ACTION_IMAGE_CAPTURE it will open the camera for capture the image
            Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            // Start the activity with camera_intent, and request pic id
            startActivityForResult(camera_intent, pic_id);


        });
        BSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });
        BsendImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click_image_id.getDrawable() == null && description.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Пусто", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Ваша даный оправленый", Toast.LENGTH_SHORT).show();
                    click_image_id.setImageBitmap(null);
                    description.setText("");
                }
            }
        });


    }

    //    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        // Match the request 'pic id with requestCode
//        if (requestCode == pic_id) {
//            // BitMap is data structure of image file which store the image in memory
//            Bitmap photo = (Bitmap) data.getExtras().get("data");
//            // Set the image in imageview for display
//            click_image_id.setImageBitmap(photo);
//        }
//    }
    void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == pic_id) {
            // BitMap is data structure of image file which store the image in memory
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            // Set the image in imageview for display
            click_image_id.setImageBitmap(photo);

        }
        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    click_image_id.setImageURI(selectedImageUri);
                }
            }
        }
    }

//    public void sendMessage() {
//        if (null == click_image_id.getDrawable()) {
//            //imageview has image
//            BsendImage.setVisibility(View.VISIBLE);
//
//        } else {
//            //imageview has no image
//            camera_open_id.setVisibility(View.GONE);
//            BSelectImage.setVisibility(View.GONE);
//
//
//        }

//    }
}