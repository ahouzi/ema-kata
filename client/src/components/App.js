import React, { useEffect, useState } from 'react';
import Videos from './Video';

const baseURL = "http://localhost:8888/api/v1/videos"



export default function App() {
    const [videos,setVideos] = useState([])

    useEffect(() => {
        const fetchData = async () => {
          const result = await fetch(baseURL);
            const data = await result.json()
            console.log(data)
            setVideos(data);
        };
     
        fetchData();
      }, []);

    return <div>
        <h1>List videos</h1>
        <Videos videos={videos} />
    </div> 
}