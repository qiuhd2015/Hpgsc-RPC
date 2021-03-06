package org.hdl.hpgsc.test.example.sync;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hdl.hggsc.rpc.client.HpgscClient;
import org.hdl.hggsc.rpc.protocol.common.StringParam;

/**
 * 
 * @author public
 *
 */
public class SyncCallClient {

	public static void main(String[] args) throws InterruptedException {
		HpgscClient client = HpgscClient.build("sync-test-client", "172.17.32.124", 9090, 3000);
		client.connect();
		
		for (int i = 0; i < Integer.MAX_VALUE; i ++) {
            try {
            	StringParam param = new StringParam("world" + i);
            	StringParam result = client.syncRequest(100, param, StringParam.class);
                System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] " + result.getValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
            Thread.sleep(2000);
        }
	}
}
