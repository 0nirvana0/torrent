package test;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.security.NoSuchAlgorithmException;

import com.turn.ttorrent.client.Client;
import com.turn.ttorrent.client.SharedTorrent;
import com.turn.ttorrent.common.Torrent;

public class TestTorrent {
	final static Logger logger = Logger.getLogger(TestTorrent.class);

	public static void main(String[] args) {
		testClient();
	}

	public static void testClient() {
		try {
			// This is the interface the client will listen on (you might need
			// something
			// else than localhost here).
			InetAddress address = InetAddress.getLocalHost();
		
			SharedTorrent torrent = SharedTorrent.fromFile(new File("data/test.torrent"), new File("D:/output"));
			// First, instantiate the Client object.
			Client client = new Client(address, torrent);

			// You can optionally set download/upload rate limits
			// in kB/second. Setting a limit to 0.0 disables rate
			// limits.
			client.setMaxDownloadRate(1000.0);
			client.setMaxUploadRate(1000.0);
			// At this point, can you either call download() to download the
			// torrent and
			// stop immediately after...
			//client.download();

			// Or call client.share(...) with a seed time in seconds:
			// client.share(3600);
			// Which would seed the torrent for an hour after the download is
			// complete.

			// Downloading and seeding is done in background threads.
			// To wait for this process to finish, call:
			// client.waitForCompletion();

			// At any time you can call client.stop() to interrupt the download.
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testTorrent() {
		try {
			// "‪‪D:/test.torrent"
			// "D:/test.torrent"//这两个一样，为啥只认下面的路径
			File file = new File("d:/test.torrent");
			Torrent torrent = Torrent.load(file);
			System.out.println(torrent.getComment());
			System.out.println(torrent.getFilenames());
			System.out.println(String.valueOf(torrent.getInfoHash()));
			System.out.println(torrent.getAnnounceList());
			System.out.println();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
