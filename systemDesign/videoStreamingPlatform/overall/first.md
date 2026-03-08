# What makes video streaming hard ??

* **A 1080p video is 2–8GB raw.** You cannot serve it like a static file.
* **If a user clicks on the middle of the video**, the player must be able to start playing from that exact spot immediately (don't force the user to watch (or download) the beginning of a video just because they want to see the end.).
* **Connections drop, bandwidth varies** — the player must adapt in real time.
* **1 million users watching simultaneously** = you need CDN edge nodes, not one server.
* **Storage, processing, and delivery** are three completely separate concerns.

---

## The Core Concept -> Adaptive Bitrate Streaming (ABR)

Imagine you upload a 4gb 1080p file, if a website serve that single file, many problems will occur ->



### case 1 -> slow internet user
* **user bandwidth** -> 1mbps, but let say video require 5mbps
* **result** -> video constantly buffer
* **result** -> playback pause every few seconds

### case 2 -> fast internet user 
* **user bandwidth** -> 100mbps, but you provide only 480p video
* **result** -> video will load fine but of poor quality

### case 3 -> internet speed changes 
* **if in this condition a single video file is used, then** ->
    * player cannot adopt
    * playback freezes