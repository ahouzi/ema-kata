import React from 'react';
import Video from './Video';

export default function Videos({ videos }) {
    return videos.map(video => <Video video={video} key={video.id} /> );
}