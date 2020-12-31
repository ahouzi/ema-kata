import React, { useEffect, useState } from 'react';
import Videos from './Video';

let baseURL = "http://localhost:8888/api/v1/videos?"



export default function App() {
    const [videos,setVideos] = useState([])
    const [tags,setTags] = useState("")
    const [level,setLevel] = useState("")

    const fetchData = async (e) => {
        e.preventDefault()
        if(tags){
            baseURL += `&tags=${tags}`
        }
        if(level){
            baseURL += `&level=${level}`
        }
        const result = await fetch(baseURL);
        const data = await result.json()
        setVideos(data);
    };
     

    return <div className="col-3">
<h2>Search videos</h2>
<form>
  <div className="form-group">
    <label>Level</label>
    <input className="form-control" value={level} onChange={e => setLevel(e.target.value)} />
  </div>
  <div className="form-group">
    <label>Tags</label>
    <input className="form-control" value={tags} onChange={e => setTags(e.target.value)} />
  </div>
  <button onClick={ e => fetchData(e)} type="submit" className="btn btn-primary">Submit</button>
</form>

<Videos videos={videos} />
</div> 
}