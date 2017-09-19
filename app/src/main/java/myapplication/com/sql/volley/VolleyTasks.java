package myapplication.com.sql.volley;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class VolleyTasks {
	static VolleyTasksListener volley;
	private static String TAG = VolleyTasks.class.getSimpleName();
	private static ProgressDialog pDialog;
	public static void makeVolleyPost(Fragment context, String url, final JSONObject postdata, String method_name) {
		volley = (VolleyTasksListener) context;
		pDialog = new ProgressDialog(context.getActivity());
		pDialog.setMessage("Loading ...");
		pDialog.setCancelable(false);
		startVollyTask(url, postdata, method_name);
	}

	public static void makeVolleyPost(final Activity context, String url, final JSONObject postdata, String method_name) {
		volley = (VolleyTasksListener) context;
		pDialog = new ProgressDialog(context);
		pDialog.setMessage("Loading ...");
		pDialog.setCancelable(false);
		startVollyTask(url, postdata, method_name);
	}

	private static void startVollyTask(String url, final JSONObject postdata, final String method_name) {
		showpDialog();
		JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.POST,
				url, postdata, new Response.Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject response) {
				Log.d(TAG, response.toString());
				hidepDialog();
				if (response != null) {
					volley.handleResult(method_name, response);
				}
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				VolleyLog.d(TAG, "1 Error: " + error.getMessage());
				hidepDialog();

				volley.handleError(error);
			}
		});
		// Adding request to request queue
		VolleyApplication.getInstance().addToRequestQueue(jsonObjReq);
		Log.i("1 url", url);
		Log.i("1 postdata", postdata.toString());
	}

	public static void makeVolleyGETObject(final Activity context, String url, final String method_name) {
		volley = (VolleyTasksListener) context;
		pDialog = new ProgressDialog(context);
		pDialog.setMessage("Loading ...");
		pDialog.setCancelable(false);
		showpDialog();
		JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.GET,
				url, null, new Response.Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject response) {
				Log.d(TAG, response.toString());
				if (response != null) {
					volley.handleResult(method_name, response);
				}
				hidepDialog();
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				VolleyLog.d(TAG, "2 Error: " + error.getMessage());
				hidepDialog();
				volley.handleError(error);
			}
		});
		// Adding request to request queue
		VolleyApplication.getInstance().addToRequestQueue(jsonObjReq);
	}

	public static void makeVolleyGETObjectFrag(Fragment context, String url, final String method_name) {
		volley = (VolleyTasksListener) context;
		pDialog = new ProgressDialog(context.getActivity());
		pDialog.setMessage("Loading ...");
		pDialog.setCancelable(false);
		showpDialog();
		JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.GET,
				url, null, new Response.Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject response) {
				Log.d(TAG, response.toString());
				if (response != null) {
					volley.handleResult(method_name, response);
				}
				hidepDialog();
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				VolleyLog.d(TAG, "3 Error: " + error.getMessage());
				hidepDialog();
				volley.handleError(error);
			}
		});
		// Adding request to request queue
		VolleyApplication.getInstance().addToRequestQueue(jsonObjReq);
	}

	private static void showpDialog() {
		if (!pDialog.isShowing())
			pDialog.show();
	}
	private static void hidepDialog() {
		pDialog.dismiss();
	}
}
